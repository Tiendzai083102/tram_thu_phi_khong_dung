package com.example.tramthuphikhongdung;

import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.UserService;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.io.PrintWriter;
import java.util.Scanner;

@SpringBootApplication
public class TramThuPhiKhongDungApplication implements CommandLineRunner {
	
	@Autowired
	UserService userService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
	public static void main(String[] args) {
		SpringApplication.run(TramThuPhiKhongDungApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// Lấy danh sách các cổng serial hiện có
		SerialPort[] serialPorts = SerialPort.getCommPorts();

		if (serialPorts.length == 0) {
			System.out.println("Không tìm thấy cổng serial.");
			while ((serialPorts = SerialPort.getCommPorts()).length ==0) {

			}
		}

		// Chọn cổng serial (ở đây sẽ chọn cổng đầu tiên)
		SerialPort serialPort = serialPorts[0];

		// Mở cổng serial
		if (serialPort.openPort()) {
			System.out.println("Đã mở cổng serial: " + serialPort.getSystemPortName());

			// Thiết lập baurate (tốc độ truyền)
			serialPort.setBaudRate(9600);

			// Đọc dữ liệu từ cổng serial
			serialPort.addDataListener(new SerialPortDataListener() {
				@Override
				public int getListeningEvents() {
					return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
				}

				@Override
				public void serialEvent(SerialPortEvent event) {
					if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
						Scanner sc  = new Scanner(serialPort.getInputStream());
						PrintWriter pw = new PrintWriter(serialPort.getOutputStream());
						String rfid = "";
						while(sc.hasNextLine()){
							rfid = sc.nextLine();
							System.out.println(rfid);
							if(rfid.equals("out")) {
								messagingTemplate.convertAndSend("/topic/data", new User());
							}else {
								User user = userService.getUserByRfid(rfid); 
								if(user!=null){
							        messagingTemplate.convertAndSend("/topic/data", user);
									pw.write(user.getBienso());
									pw.flush();
								}else{
									pw.write("false");
									pw.flush();
								}
							}
						}
					}
				}
			});
		} else {
			System.out.println("Không thể mở cổng serial: " + serialPort.getSystemPortName());
		}
	}
}

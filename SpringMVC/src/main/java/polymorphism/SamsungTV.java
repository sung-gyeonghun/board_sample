package polymorphism;

import org.springframework.stereotype.Component;

@Component("tv1")
public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("===> Samsung(1) ��ü ����");
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(2) ��ü ����");
		this.speaker = speaker;
		this.price = price;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�.");
		System.out.println("SamsungTV ���� : "+price+"��");
	}

	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}

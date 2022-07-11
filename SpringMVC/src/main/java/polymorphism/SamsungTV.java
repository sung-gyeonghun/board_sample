package polymorphism;

import org.springframework.stereotype.Component;

@Component("tv1")
public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("===> Samsung(1) °´Ã¼ »ý¼º");
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(2) °´Ã¼ »ý¼º");
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
		System.out.println("SamsungTV---Àü¿ø ÄÒ´Ù.");
		System.out.println("SamsungTV °¡°Ý : "+price+"¿ø");
	}

	public void powerOff() {
		System.out.println("SamsungTV---Àü¿ø ²ö´Ù.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}

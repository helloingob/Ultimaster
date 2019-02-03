package de.fhl.ultimaster.api.v1.utils;

import de.fhl.ultimaster.shared.printer.Printer;

public class TestPrinter {

	private static TestPrinter instance;
	private Printer printer;

	private TestPrinter() {
		printer = new Printer();
		printer.setHost("192.168.0.14");
		printer.setPrinterId("fc39faebcb1ccc92955f25c720a8ef11");
		printer.setPrinterKey("02561c264e02c2abb4cb97025a1c5a1717075915fbf11424dc072280a586b506");
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public static TestPrinter getInstance() {
		if (instance == null) {
			instance = new TestPrinter();
		}
		return instance;
	}

}

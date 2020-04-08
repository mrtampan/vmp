package tess;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

private String productName;
private int price;
private int stock;

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public VendingMachine(String productName, int price, int stock) {
	this.productName = productName;
	this.price = price;
	this.stock = stock;
}

public VendingMachine() {
}

public int inputanInt () {
	Scanner pilih = new Scanner(System.in);
	int strPilih = pilih.nextInt();
	return strPilih;
}

public String inputanString () {
	Scanner pilih = new Scanner(System.in);
	String strPilih = pilih.nextLine();
	return strPilih.toLowerCase();
}

private static Integer[] satuanUang = new Integer[] {2000, 5000, 10000, 20000, 50000};

public boolean pecahanUang (int uangParam) {
	List<Integer> list = Arrays.asList(satuanUang);
	
	if(list.contains(uangParam)) {
	  return true;
	}else {
	  return false;
	}
}

public void changeStok (int param) {
	int stok = 0;
	stok = param - 1;
}

//public static void main(String[] args) {
//	System.out.println("\n");
//
//	VendingMachine va = new VendingMachine();
//	VendingMachine biskuit = new VendingMachine("Biskuit", 6000, 5);
//	VendingMachine chips = new VendingMachine("Chips", 8000, 10);
//	VendingMachine oreo = new VendingMachine("Oreo", 10000, 20);
//	VendingMachine tango = new VendingMachine("Tango", 12000, 30);
//	VendingMachine coklat = new VendingMachine("Cokelat", 15000, 15);
//	List<VendingMachine> allProduct = new ArrayList();
//	allProduct.add(biskuit);
//	allProduct.add(chips);
//	allProduct.add(oreo);
//	allProduct.add(tango);
//	allProduct.add(coklat);
//	Integer menu = null;
//	int uang = 0;
//	int kembalian = 0;
//	String choose = null;
//	
//	System.out.println("Selamat Datang di Vending Machine Puppeteer \nDibawah ini menunya:");
//	
//	int count = 1;
//	for (VendingMachine productnya : allProduct) {
//		System.out.println(count + ". " + productnya.getProductName());
//		count++;
//	}
//	
//	System.out.println("Pilih berdasarkan angka menu:");
//	menu = va.inputanInt();
//	VendingMachine oneProduct = allProduct.get(menu-1);
//	
//	
//	if(oneProduct.getStock() <= 0) {
//		System.out.println("Stok Produk abis");
//		main(args);
//		System.exit(0);
//	}
//	
//	System.out.println("\n");
//	System.out.println("Nama Product: " + oneProduct.getProductName() + " Harga: " + oneProduct.getPrice() + " Stok: " + oneProduct.getStock());
//	System.out.println("Masukan nominal uang kamu:");
//	uang = va.inputanInt();
//	
//	if(!va.pecahanUang(uang)) {
//		System.out.println("Pecahan Uang tidak diterima");
//		main(args);
//		System.exit(0);
//	}
//	
//	if(uang < oneProduct.getPrice()) {
//		System.out.println("Uang kamu tidak cukup");
//		main(args);
//		System.exit(0);
//	}
//	System.out.println("\n");
//	kembalian = uang - oneProduct.getPrice();
//	System.out.println("Pembelian Berhasil");
//	if(kembalian >= 0 ) {
//		System.out.println("Kembalian: " + kembalian + "\n");
//	}
//	
//	System.out.println("Apakah ada pembelian lain ?");
//	System.out.println("Ketik y atau n");
//	choose = va.inputanString();
//	if(choose.equals("y")) {
//		main(args);
//		va.changeStok(oneProduct.getStock());
//		System.exit(0);
//	}
//	
//	
//}

public static void main(String[] args) {
	
	VendingMachine va = new VendingMachine();
	VendingMachine biskuit = new VendingMachine("Biskuit", 6000, 0);
	VendingMachine chips = new VendingMachine("Chips", 8000, 10);
	VendingMachine oreo = new VendingMachine("Oreo", 10000, 20);
	VendingMachine tango = new VendingMachine("Tango", 12000, 30);
	VendingMachine coklat = new VendingMachine("Cokelat", 15000, 15);
	List<VendingMachine> allProduct = new ArrayList();
	allProduct.add(biskuit);
	allProduct.add(chips);
	allProduct.add(oreo);
	allProduct.add(tango);
	allProduct.add(coklat);
	Integer menu = null;
	int uang = 0;
	int kembalian = 0;
	String choose = null;
	
	while(true) {
		System.out.println("\n");
		System.out.println("Selamat Datang di Vending Machine Puppeteer \nDibawah ini menunya:");
		
		int count = 1;
		for (VendingMachine productnya : allProduct) {
			System.out.println(count + ". " + productnya.getProductName());
			count++;
		}
		
		System.out.println("Pilih berdasarkan angka menu:");
		menu = va.inputanInt();
		VendingMachine oneProduct = allProduct.get(menu-1);
		
		
		if(oneProduct.getStock() <= 0) {
			System.out.println("Stok Produk abis");
			continue;
		}
		
		System.out.println("\n");
		System.out.println("Nama Product: " + oneProduct.getProductName() + " Harga: " + oneProduct.getPrice() + " Stok: " + oneProduct.getStock());
		System.out.println("Masukan nominal uang kamu:");
		uang = va.inputanInt();
		
		if(!va.pecahanUang(uang)) {
			System.out.println("Pecahan Uang tidak diterima");
			continue;
		}
		
		if(uang < oneProduct.getPrice()) {
			System.out.println("Uang kamu tidak cukup");
			continue;
		}
		System.out.println("\n");
		kembalian = uang - oneProduct.getPrice();
		System.out.println("Pembelian Berhasil");
		if(kembalian >= 0 ) {
			System.out.println("Kembalian: " + kembalian + "\n");
		}
		
		System.out.println("Apakah ada pembelian lain ?");
		System.out.println("Ketik y atau n");
		choose = va.inputanString();
		if(choose.equals("y")) {
			oneProduct.setStock(oneProduct.getStock() - 1);
			continue;
		}
		
		break;
	
	}

}
	



}

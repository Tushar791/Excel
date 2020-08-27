package com.ReadWrite.main;

import java.io.IOException;
import java.util.ArrayList;

import com.ReadWrite.Read.ReadExcel;
import com.ReadWrite.model.Pizza;
import com.ReadWrite.write.WriteExcel;

public class Main {

	public static void main(String[] args) throws IOException {
		ReadExcel rd = new ReadExcel();
		ArrayList<Pizza> sourceList = rd.read("Source");
		ArrayList<Pizza> targetList = rd.read("Target");
		
		WriteExcel wr = new WriteExcel();
		wr.write(sourceList, targetList);
		

	}

}

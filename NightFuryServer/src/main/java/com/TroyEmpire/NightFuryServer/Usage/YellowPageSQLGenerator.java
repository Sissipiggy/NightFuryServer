package com.TroyEmpire.NightFuryServer.Usage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class YellowPageSQLGenerator {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File readFile = new File("C:/暨南大学校园黄页.txt");
		File writeFile = new File("C:/out.txt");
		if (!writeFile.exists())
			writeFile.createNewFile();
		writeFile.setWritable(true);
		BufferedReader reader = new BufferedReader(new FileReader(readFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				writeFile.getAbsoluteFile()));
		String readLine;
		String writeLine;
		while ((readLine = reader.readLine()) != null) {
			String[] result = readLine.split("[#]");
			writeLine = "insert into YellowPageUnit(name,phoneNumber,managerName,description) values("
					+ "\'" + result[0] + "\'"
					+ ","
					+ "\'" + result[1] + "\'"
					+ ","
					+ "\'" +  result[2]+ "\'"
					+ ","
					+ "\'" +  result[3] + "\'" + ");" + "\n";
			System.out.println(writeLine);
			writer.append(writeLine);
		}
		writer.close();

	}
}

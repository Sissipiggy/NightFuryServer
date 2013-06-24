package com.TroyEmpire.NightFuryServer.Usage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class RestaurangSQLgenerator {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		generatRestaurantSQL();
		generateMealSQL();

	}

	private static void generatRestaurantSQL() throws Exception {
		File readFile = new File("C:/餐馆.txt");
		File writeFile = new File("C:/restaurant.sql");
		if (!writeFile.exists())
			writeFile.createNewFile();
		writeFile.setWritable(true);
		BufferedReader reader = new BufferedReader(new FileReader(readFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				writeFile.getAbsoluteFile()));
		String readLine = reader.readLine();
		String writeLine;
		while ((readLine = reader.readLine()) != null) {
			String[] result = readLine.split("[#]");
			writeLine = "insert into Restaurant(phoneNumber,description,managerName,transporterName,name,type,bookmarked,minimumOrder,deliverTime) values("
					+ "\'"
					+ result[0]
					+ "\'"
					+ ","
					+ "\'"
					+ result[1]
					+ "\'"
					+ ","
					+ "\'"
					+ result[2]
					+ "\'"
					+ ","
					+ "\'"
					+ result[3]
					+ "\'"
					+ ","
					+ "\'"
					+ result[4]
					+ "\'"
					+ ","
					+ "\'"
					+ result[5]
					+ "\'"
					+ ","
					+ result[6]
					+ ","
					+ result[7]
					+ ","
					+ result[8] + ");" + "\n";
			System.out.println(writeLine);
			writer.append(writeLine);
		}
		reader.close();
		writer.close();

	}

	private static void generateMealSQL() throws Exception {
		File writeFile = new File("C:/meals.sql");
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				writeFile.getAbsoluteFile()));

		File mealsFolder = new File("C:/菜");
		File[] meals = mealsFolder.listFiles();

		String readLine;
		String writeLine;
		for (File meal : meals) {
			int restId = Integer.valueOf(meal.getName().split("['_']")[0]);
			BufferedReader reader = new BufferedReader(new FileReader(meal));
			while ((readLine = reader.readLine()) != null) {
				String[] result = readLine.split("[#]");
				writeLine = "insert into Meal(restaurantId,name,price,description) values("
						+ restId
						+ ","
						+ "\'"
						+ result[0]
						+ "\'"
						+ ","
						+ result[1]
						+ ","
						+ "\'"
						+ result[0]
						+ "\'"
						+ ");"
						+ "\n";
				System.out.println(writeLine);
				writer.append(writeLine);
			}
			reader.close();
		}
		writer.close();
	}
}
package com.TroyEmpire.NightFuryServer.Util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

	public static <T> ArrayList<T> reverse(List<T> list) {
		ArrayList<T> theReturn = new ArrayList<T>(list.size());

		for (int i = list.size() - 1; i >= 0; i--)
			theReturn.add(list.get(i));

		return theReturn;
	}
}

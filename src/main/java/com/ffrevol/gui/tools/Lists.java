package com.ffrevol.gui.tools;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static <T2, T1> List<T2> transform(List<T1> list,
			Function<T1, T2> function) {
		List<T2> transformedList = new ArrayList<T2>();
		for(T1 e : list)
		{
			transformedList.add(function.apply(e));
		}
		return transformedList;
	}

}

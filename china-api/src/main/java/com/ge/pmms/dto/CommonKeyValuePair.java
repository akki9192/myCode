package com.ge.pmms.dto;

import java.util.ArrayList;
import java.util.List;

public class CommonKeyValuePair
{
	public List addDefaultSelect(List<DropDownEntry> array)
	{
		DropDownEntry dropDownEntry = new DropDownEntry();
		dropDownEntry.setKey("0");
		dropDownEntry.setVal("--全部 Select --");
		array.add(dropDownEntry);
		return array;
	}
}

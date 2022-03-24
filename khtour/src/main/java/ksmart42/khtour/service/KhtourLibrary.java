package ksmart42.khtour.service;

public class KhtourLibrary {

	// 1 : 숫자에 K, M 달아주는 메서드, 입력값 : FLOAT  -> 출력값 변경된 String (예: 30K)
	static public String cntConverter(Float cnt) {	
		String result="";
		Float tempFloat = 0f;
		if (cnt>=1000000)
		{
			if(Math.round(cnt/100000)%10 ==0)
			{
				result = String.valueOf(Math.round(cnt/1000000))+"M";
			}
			else
			{
				tempFloat = (float)Math.round(cnt/100000);
				tempFloat = tempFloat/10;
				result = String.valueOf(tempFloat)+"M";
			}
		}
		else if (cnt>=1000)
		{
			if(Math.round(cnt/100)%10 ==0)
			{
				result = String.valueOf(Math.round(cnt/1000))+"K";
			}
			else
			{
				tempFloat = (float)Math.round(cnt/100);
				tempFloat = tempFloat/10;
				result = String.valueOf(tempFloat)+"K";
			}
		}
		else
		{	
			result = String.valueOf(Math.round(cnt));		
		}
		
		return result;
	}
	
	
	
	
	
}

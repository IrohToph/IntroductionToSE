package Windows;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test2 {
	public static ArrayList<CountryData> getData() {
		int count = 0;
		String URL = "https://www.worldometers.info/coronavirus/?";
	    ArrayList<CountryData> dataRecord = new ArrayList<CountryData>();
	    try {
	    	Document source = Jsoup.connect(URL).timeout(30*1000).get();
	    	Element table = source.select("tbody").first();
	    	Elements rows = table.select("tr");
	    	for (Element row: rows) {
	    		Elements data = row.select("td");
	    		count++;
	    		System.out.println(data.get(1).text());
	    		dataRecord.add(new CountryData(data.get(1).text(), data.get(2).text(), data.get(3).text(), data.get(4).text(), data.get(5).text(), data.get(6).text(), data.get(7).text()));
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    System.out.println(count);
	    return dataRecord;
	}
	public static void main(String[] args) {
		System.out.println("231".length());
	}
}

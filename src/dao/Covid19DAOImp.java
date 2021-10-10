package dao;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import utility.Covid19;

public class Covid19DAOImp implements Covid19DAO {

	@Override
	public List<Covid19> getAllStatesCovid19() {
		Covid19 covid19 = null;
		List<Covid19> listCovid = null;
		
		String url = "https://covid-19-statistics.p.rapidapi.com/reports?iso=IND";
		
		
		
		try {
			listCovid = new ArrayList<Covid19>();
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("x-rapidapi-key", "cd247c3a0fmsh3a0bc8760db6763p1de938jsn3cc1a6c736df")
					.header("x-rapidapi-host", "covid-19-statistics.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
//			System.out.println(response.body());
			
			JSONObject jsonObject = new JSONObject(response.body().toString());
			
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			
			System.out.println(jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				
				covid19 = new Covid19();
				
				covid19.setConfirmed(jsonArray.getJSONObject(i).get("confirmed").toString());
				covid19.setRecovered(jsonArray.getJSONObject(i).get("recovered").toString());
				covid19.setDeaths(jsonArray.getJSONObject(i).get("deaths").toString());
				covid19.setProvince(jsonArray.getJSONObject(i).getJSONObject("region").get("province").toString());
				covid19.setDate(jsonArray.getJSONObject(i).get("date").toString());
				covid19.setLast_update(jsonArray.getJSONObject(i).get("last_update").toString());
				
				System.out.println("-------------Covid 19----------"+i);
				System.out.println("Province : "+jsonArray.getJSONObject(i).getJSONObject("region").get("province"));
				System.out.println("Confirmed Case : "+jsonArray.getJSONObject(i).get("confirmed"));
				System.out.println("Deaths : "+jsonArray.getJSONObject(i).get("deaths"));
				System.out.println("Recovered Case : "+jsonArray.getJSONObject(i).get("recovered")+"\n\n");
				
				
				listCovid.add(covid19);
			}
			
			
			
			
//			System.out.println(jsonObject.getJSONObject("data").get("last_update"));
			
	    	
	    } catch (Exception e) {
			System.out.println(e);
		}
		return listCovid;
	    
		
		
		
		
		
	}

	@Override
	public List<Covid19> getGlobalCovid19() {
		
		
		
		Covid19 covid19 = null;
		List<Covid19> listCovid = null;
		
		String url = "https://covid-19-statistics.p.rapidapi.com/reports/total";
		
		
		
		try {
			listCovid = new ArrayList<Covid19>();
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("x-rapidapi-key", "cd247c3a0fmsh3a0bc8760db6763p1de938jsn3cc1a6c736df")
					.header("x-rapidapi-host", "covid-19-statistics.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
//			System.out.println(response.body());
			
			JSONObject jsonObject = new JSONObject(response.body().toString());
			
			System.out.println(jsonObject.getJSONObject("data").get("recovered"));

			
			System.out.println(jsonObject.length());
			for (int i = 0; i < jsonObject.length(); i++) {
				
				covid19 = new Covid19();
				
				covid19.setConfirmed(jsonObject.getJSONObject("data").get("confirmed").toString());
				covid19.setRecovered(jsonObject.getJSONObject("data").get("recovered").toString());
				covid19.setDeaths(jsonObject.getJSONObject("data").get("deaths").toString());
				
				// convert date and time
				String[] dateAndtime = jsonObject.getJSONObject("data").get("last_update").toString().split(" ",2);
				String date = dateAndtime[0];
				String time = dateAndtime[1];
				String[] ago = time.split(":",5);
				int upadateMin = Integer.parseInt(ago[1]);
				int now = java.time.LocalTime.now().getMinute();
				
				//Check update minute
				if (java.time.LocalDate.now().toString().equals(date) && java.time.LocalTime.now().getHour() != Integer.parseInt(ago[0]) ) {
					int cHour = (java.time.LocalTime.now().getHour() - Integer.parseInt(ago[0]));
					
					 upadateMin = cHour*60 - upadateMin;
					 upadateMin = upadateMin + java.time.LocalTime.now().getMinute();
					 System.out.println("hour : min "+cHour +" " + upadateMin);
					 if (upadateMin > 60) {
						int hour = upadateMin/60; // hour
						upadateMin = upadateMin - hour*60; // minute
						covid19.setLast_update(hour+ ":"+ upadateMin+ " hour ago");
					}else {
						
						covid19.setLast_update(upadateMin+ " minute ago");
					}
				}else {
					int update = now - upadateMin;
					System.out.println("Ago : "+ update +" ago");
					covid19.setLast_update(update+" minute ago");
					
				}
				
				
				
				
				
				covid19.setDate(java.time.LocalDate.now().getDayOfMonth()+"-"+java.time.LocalDate.now().getMonth()+"-"+java.time.LocalDate.now().getYear());
				
				
				System.out.println("-------------Covid 19----------"+i);
				System.out.println("Confirmed Case : "+jsonObject.getJSONObject("data").get("confirmed"));
				System.out.println("Deaths : "+jsonObject.getJSONObject("data").get("deaths"));
				System.out.println("Recovered Case : "+jsonObject.getJSONObject("data").get("recovered")+"\n\n");
				System.out.println("Date : "+jsonObject.getJSONObject("data").get("date")+"\n\n");
				System.out.println("LastUpdate : "+jsonObject.getJSONObject("data").get("last_update")+"\n\n");
				System.out.println("C Time"+(java.time.LocalTime.now().getMinute()));
				
				listCovid.add(covid19);
			}
			
			
			
			
//			System.out.println(jsonObject.getJSONObject("data").get("last_update"));
			
	    	
	    } catch (Exception e) {
			System.out.println(e);
		}
		return listCovid;
	    
	}

	//India Covid19 Data
	@Override
	public List<Covid19> getIndiaCovid19() {
		Covid19 covid19 = null;
		List<Covid19> listCovid = null;
		
				
		
		try {
			
			
			listCovid = new ArrayList<Covid19>();
			//Code For obtain API Data From JSON
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://covid-19-data.p.rapidapi.com/country?name=india&format=json"))
					.header("x-rapidapi-key", "cd247c3a0fmsh3a0bc8760db6763p1de938jsn3cc1a6c736df")
					.header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			JSONArray array = new JSONArray(response.body());
			
			
			System.out.println(array.getJSONObject(0).get("country"));
			
			//Set Values
			covid19 = new Covid19();
			
			covid19.setConfirmed(array.getJSONObject(0).get("confirmed").toString());
			covid19.setRecovered(array.getJSONObject(0).get("recovered").toString());
			covid19.setDeaths(array.getJSONObject(0).get("deaths").toString());
			covid19.setDate(java.time.LocalDate.now().getDayOfMonth()+"-"+java.time.LocalDate.now().getMonth()+"-"+java.time.LocalDate.now().getYear());
			

			try {
				// plus is a meta character so, we used //+
				String[] splitDate = array.getJSONObject(0).get("lastUpdate").toString().split("\\+",2);
				String Datepattern = splitDate[0];
				LocalDateTime dateTime = LocalDateTime.parse(Datepattern);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
				String lastUpdateTime = dateTime.format(formatter); 
				covid19.setLast_update("On "+lastUpdateTime);
				System.out.println("Formate Time :" +lastUpdateTime);
			} catch (Exception e) {
				e.getMessage();
			}
	

			
			listCovid.add(covid19);

			
				
			
		} catch (Exception e) {
		e.getStackTrace();	
		}
		return listCovid;
	}

}

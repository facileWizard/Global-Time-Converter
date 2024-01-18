package WorldTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
		
public class WorldTimeConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner sc = new Scanner(System.in);
		        String[] availableid = TimeZone.getAvailableIDs();

		        // Taking user input for local time zone
		        System.out.println("Enter your local time zone, Please select a number: ");
		        
		        for(int i=0; i<availableid.length ;i++) {
		        	System.out.println((i+1) + " : " + availableid[i]);
		        }
		        int localZoneIdint = sc.nextInt();
		        String localZoneIdStr = availableid[localZoneIdint-1];
		        ZoneId localZoneId = ZoneId.of(localZoneIdStr);

		        // Taking user input for country time zone
		        System.out.print("Enter the country time zone, Please select a number :");
		        int countryZoneIdint = sc.nextInt();
		        sc.close();
		        String countryZoneIdStr = availableid[countryZoneIdint-1];
		        ZoneId countryZoneId = ZoneId.of(countryZoneIdStr);

		        // Convert local time to country time
		        LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
		        LocalDateTime countryDateTime = localDateTime.atZone(localZoneId).withZoneSameInstant(countryZoneId).toLocalDateTime();

		        // Formating Date and time
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String localTime = formatter.format(localDateTime);
		        String countryTime = formatter.format(countryDateTime);

		        // Showing output
		        System.out.println("Local time (" + localZoneId + "): " + localTime);
		        System.out.println("Country time (" + countryZoneId + "): " + countryTime);
		    }
		}



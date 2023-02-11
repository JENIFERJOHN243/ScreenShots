package task;

public class TimeConversion24Hrs {

	public static void main(String[] args) {
		String s = "07:05:45PM";
		String tArr[] = s.split(":");
        String AmPm = tArr[2].substring(2,4);
       // int hh,mm,ss;
//        hh = Integer.parseInt(tArr[0]);
//        mm = Integer.parseInt(tArr[1]);
//        ss = Integer.parseInt(tArr[2].substring(0,2));
//        System.out.println(hh);
//        System.out.println(mm);
//        System.out.println(ss);
        String h=tArr[0];
        int hr = Integer.parseInt(tArr[0]);
        if(AmPm.equals("AM") && tArr[0].equals("12"))
            h="00";
        else if(AmPm.equals("PM") && hr<12) {
        	hr = hr+12;
        	h = String.valueOf(hr);
        }
        
//        System.out.printf("%02d:%02d:%02d",h,mm,ss);
       String result = h+":"+tArr[1]+":"+tArr[2].substring(0,2);
       System.out.println(result);
	}

	
	
//	String s = "07:05:45AM";
//	String hours= s.substring(0,2);
//    String minutes=s.substring(3,5);
//    String second=s.substring(6,8);
//    String tempHour;
//    String lastHour= hours+":"+minutes+":"+second;
//    if(s.contains("PM")){
//
//        if(hours.equals("12")){
//            tempHour ="12";
//            lastHour= tempHour+":"+minutes+":"+second;
//
//        }
//        else{
//            int hoursInt=Integer.parseInt(hours);
//            hoursInt=hoursInt+12;
//            tempHour =String.valueOf(hoursInt);
//            lastHour= tempHour+":"+minutes+":"+second;   
//        }
//
//    }
//    else if(s.contains("AM")){
//
//        if(hours.equals("12")){
//            tempHour="00";
//            lastHour= tempHour+":"+minutes+":"+second;   
//        }
//    }

}

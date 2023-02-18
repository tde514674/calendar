package calendar;
import java.util.Arrays;

public class Mycalender{
	static int[] daymonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static boolean leapyear(int x){
		if(x%4==0 && (x%100!=0 || x%400==0)) return true;
		else return false;
	}//leapyear

	public static int daycount(int dd,int mm,int yy,int dd2,int mm2,int yy2){
		int old_dd = dd,old_mm = mm,old_yy = yy;
		int count = 0;
		while(dd!=dd2 || mm!=mm2 || yy!=yy2){
			if(leapyear(yy-543)) daymonth[2]=29;
			else daymonth[2]=28;
			dd++;
			if(dd > daymonth[mm]){
				dd = 1;
				mm++;

			  if(mm > 12){
				mm = 1;
				yy++;
				if(leapyear(yy)) daymonth[2]=29;
			    else daymonth[2]=28;
			 }
			}
			count++;
		}
		return count;
	}//daycount

	public static int[] dayforward(int dd,int mm,int yy,int f){
		int count = f;
		while(count!=0){
			if(leapyear(yy-543)) daymonth[2]=29;
			else daymonth[2]=28;
			dd++;
			if(dd > daymonth[mm]){
				dd = 1;
				mm++;
				if(mm > 12){
				mm = 1;
				yy++;
				if(leapyear(yy)) daymonth[2]=29;
			    else daymonth[2]=28;
			}
			}
			count--;
		}
		int[] ddmmyy ={dd,mm,yy};
		return ddmmyy;
	}//dayforward

	public static int daycountbackward(int dd, int mm, int yy, int dd2, int mm2 ,int yy2){
		int count = 0;
		while(dd!=dd2 || mm!=mm2 || yy!=yy2){
			if(leapyear(yy-543)) daymonth[2]=29;
			else daymonth[2]=28;
			dd--;
			if(dd == 0){
				mm--;
				dd = daymonth[mm];
			}
			if(mm == 0){
				mm = 12;
				yy--;
				if(leapyear(yy-543)) daymonth[2]=29;
			    else daymonth[2]=28;
			}
			count++;
		}
		return count;
	}//daycountbackward

	public static int[] daybackward(int dd,int mm,int yy,int b){
		int count = b;
		while(count !=0){
			if(leapyear(yy-543)) daymonth[2]=29;
			else daymonth[2]=28;
			dd--;
			if(dd == 0){
				mm--;
				dd = daymonth[mm];
			}
			if(mm == 0){
				mm = 12;
				yy--;
				if(leapyear(yy-543)) daymonth[2]=29;
			    else daymonth[2]=28;
			}
			count--;
		}
		int[] ddmmyy ={dd,mm,yy};
		return ddmmyy;
	}

}

package orgs.imrul.client;

import orgs.imrul.webservices.AuthorService;

public class Client {
	public static void main(String args[]){
//		int year = Integer.parseInt(args[0]);
//		int month = Integer.parseInt(args[1]);
//		int day = Integer.parseInt(args[2]);
		int year = 1980;
		int month = 9;
		int day = 11;
		
		AuthorService service = new AuthorService();
		int result = service.getAuthorPort().getAgeByDateOfBirth(year, month, day);
		System.out.println(result);
		
	}
}

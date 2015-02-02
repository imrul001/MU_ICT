package orgs.imrul.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.imrul.business.AuthorServiceImpl;

@WebService
public class Author {
	
	AuthorServiceImpl serviceImpl = new AuthorServiceImpl();
	
	@WebMethod
	public int getAgeByDateOfBirth(int year, int month, int day){
		return serviceImpl.getAuthorAge(year, month, day);
		
	}

}

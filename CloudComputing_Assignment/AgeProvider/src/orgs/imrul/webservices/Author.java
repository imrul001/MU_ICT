package orgs.imrul.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.imrul.business.AuthorServiceImpl;
import orgs.imrul.classList.AgeClass;

@WebService
public class Author {
	
	AuthorServiceImpl serviceImpl = new AuthorServiceImpl();
	
	@WebMethod
	public AgeClass getAgeByDateOfBirth(int year, int month, int day, String name){
		return serviceImpl.getAuthorAge(year, month, day, name);
		
	}

}

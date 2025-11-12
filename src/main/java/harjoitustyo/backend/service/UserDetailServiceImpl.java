package harjoitustyo.backend.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import harjoitustyo.backend.model.AppUser;
import harjoitustyo.backend.model.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppUserRepository repository;

    public UserDetailServiceImpl(AppUserRepository appUserRepository) {
			this.repository = appUserRepository; 
	}

    @Override
    public UserDetails loadUserByUsername(String userN) throws UsernameNotFoundException {   
    	AppUser curruser = repository.findByUserN(userN);
        UserDetails user = new org.springframework.security.core.userdetails.User(userN, curruser.getPassword(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   

}

package com.ibm.RepoGitHub.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibm.RepoGitHub.security.entity.User;

@Service
public class UserService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {		
		User user = new User();
		
		
		if(userName.equals("teste")) {
			user.setId(0L);
			user.setName("teste");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
			String encodedPassword = encoder.encode("1234");
			user.setPassword(encodedPassword);
			user.setUserName("teste");
		}
		
		Optional<User>	possibleUser = Optional.of(user);
		
		return possibleUser.orElseThrow(() -> new	UsernameNotFoundException("Não	foi	possível encontrar o usuário: "	+ userName));
	}
	
	public UserDetails loadUserById(Long userId) {
		User user = new User();	
		if(userId.equals(0L)){
			user.setId(0L);
			user.setName("teste");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
			String encodedPassword = encoder.encode("1234");
			user.setPassword(encodedPassword);
			user.setUserName("teste");
		}
		
		Optional<User>	possibleUser = Optional.of(user);
		return	possibleUser.orElseThrow(
						()	->	new	UsernameNotFoundException("Não	foi	possível	encontrar	o	usuário	com	id:	"	+
								userId));
}
			
				
}
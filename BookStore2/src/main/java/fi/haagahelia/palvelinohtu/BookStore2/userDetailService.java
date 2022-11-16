package fi.haagahelia.palvelinohtu.BookStore2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.palvelinohtu.BookStore2.domain.user;
import fi.haagahelia.palvelinohtu.BookStore2.domain.userRepository;

public class userDetailService {

	@Service
	public class UserDetailServiceImpl implements UserDetailsService {
		private final userRepository repository;

		@Autowired
		public UserDetailServiceImpl(userRepository userRepository) {
			this.repository = userRepository;
		}

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			user curruser = repository.findByUsername(username);
			UserDetails user = new org.springframework.security.core.userdetails.User(username,
					curruser.getPasswordHash(), AuthorityUtils.createAuthorityList(curruser.getRole()));
			return user;
		}
	}
}
package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.UserDTO;
import bg.tu_varna.sit.task_manager.entities.User;
import bg.tu_varna.sit.task_manager.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

  private final UserRepository repository;
  private final ModelMapper mapper;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImp(UserRepository repository, ModelMapper mapper,PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.mapper = mapper;
    this.passwordEncoder=passwordEncoder;
  }

  @Override
  public UserDTO create(UserDTO dto) {
    User user=mapper.map(dto,User.class);
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    return mapper.map(repository.save(user),UserDTO.class) ;
  }

  @Override
  public UserDTO readByEmail(String email) {
    return mapper.map(repository.findByEmail(email),UserDTO.class);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user=repository.findByEmail(username)
        .orElseThrow(()->new UsernameNotFoundException("User"));

    return org.springframework.security.core.userdetails.User
        .builder()
        .username(user.getName())
        .password(user.getPassword())
        .build();
  }
}

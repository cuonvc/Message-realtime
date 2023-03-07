package com.project.message.messagerealtime.mapper;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import org.hibernate.annotations.Source;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, builder = @Builder(disableBuilder = true))
@Component
public interface UserMapper {

    @Mapping(source = "registerDate", target = "createdDate")
    User mapUserFromRegRequest(RegisterRequest request);

    void mapUserDtoToUser(UserDTO userDTO, @MappingTarget User user);

    UserDTO mapUserDTOFromUser(User user);
    User mapUserFromUserDTO(UserDTO userDTO);
}

package com.project.message.messagerealtime.mapper;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, builder = @Builder(disableBuilder = true))
@Component
public interface UserMapper {

    User regRequestToUser(RegisterRequest request);

    UserDTO mapUserDTOFromUser(User user);
    User mapUserFromUserDTO(UserDTO userDTO);
}

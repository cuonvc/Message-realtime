package com.project.message.messagerealtime.mapper;

import com.project.message.messagerealtime.model.entity.RefreshToken;
import com.project.message.messagerealtime.model.payload.RefreshTokenResponse;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface TokenMapper {

    @Mapping(source = "token", target = "refreshToken")
//    @Mapping(source = )
    RefreshTokenResponse mapFromRefreshTokenObject(RefreshToken refreshTokenObject);
}

package com.mryw.mapper;

import com.mryw.dto.UserMrywDTO;
import com.mryw.dto.UserMrywRequestDTO;
import com.mryw.model.UserMryw;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMrywMapper {
    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "accountURL", target = "accountURL"),
    })
    UserMryw mapUserMrywRequestDTOToUserMryw(UserMrywRequestDTO dto);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "accountURL", target = "accountURL"),
    })
    UserMryw mapUserMrywDtoToUserMryw(UserMrywDTO dto);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "accountURL", target = "accountURL"),
    })
    UserMrywDTO mapUserMrywToUserMrywDto(UserMryw dto);
}

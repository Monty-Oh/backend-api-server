package com.inmemory.content.interfaces.rest.mapper;

import com.inmemory.content.common.configuration.MapStructConfig;
import com.inmemory.content.domain.model.dto.AlbumDto;
import com.inmemory.content.domain.model.dto.AlbumListDto;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDto;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDtoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public abstract class AlbumListQueryMapper {
    public abstract AlbumListQuery mapToQuery(List<String> tagList);

    @Mapping(target = "albumList", source = "albumDtoList")
    public abstract AlbumListRspDto mapToRspDto(AlbumListDto albumListDto);
}

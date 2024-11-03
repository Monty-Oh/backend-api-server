package com.inmemory.content.interfaces.rest.mapper;

import com.inmemory.content.common.configuration.MapStructConfig;
import com.inmemory.content.domain.model.aggregate.Album;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public abstract class AlbumListQueryMapper {
    public abstract AlbumListQuery mapToQuery(List<String> tagList);

    public abstract AlbumListRspDto mapToRspDto(List<Album> albumList);
}

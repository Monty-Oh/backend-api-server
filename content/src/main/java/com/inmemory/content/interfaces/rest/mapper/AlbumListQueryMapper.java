package com.inmemory.content.interfaces.rest.mapper;

import com.inmemory.content.common.configuration.MapStructConfig;
import com.inmemory.content.domain.model.query.AlbumListQuery;
import com.inmemory.content.domain.model.vo.AlbumListVo;
import com.inmemory.content.domain.model.vo.AlbumVo;
import com.inmemory.content.domain.model.vo.TagVo;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDto;
import com.inmemory.content.interfaces.rest.dto.AlbumListRspDtoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(config = MapStructConfig.class)
public abstract class AlbumListQueryMapper {

    /**
     * 앨범 리스트 조회 쿼리로 매핑
     *
     * @param tagList 조회하고자 하는 태그 리스트
     * @return 쿼리 매핑 결과
     */
    public AlbumListQuery mapToQuery(List<String> tagList) {
        if (Objects.isNull(tagList)) tagList = new ArrayList<>();
        return AlbumListQuery.builder()
                .tagNameList(tagList)
                .build();
    }

    /**
     * 조회 결과를 응답용 ResponseDto 로 변환
     *
     * @param albumListVo 조회 결과
     * @return 응답 객체
     */
    @Mapping(target = "albumList", source = "albumVoList", qualifiedByName = "AlbumListRspDto.albumList")
    public abstract AlbumListRspDto mapToRspDto(AlbumListVo albumListVo);

    @Named(value = "AlbumListRspDto.albumList")
    @Mapping(target = "tagNameList", source = "tagVoList", qualifiedByName = "AlbumListRspDto.albumList.tagNameList")
    protected abstract AlbumListRspDtoItem mapToRspDto(AlbumVo albumVo);

    @Named(value = "AlbumListRspDto.albumList.tagNameList")
    protected List<String> mapToRspDto(List<TagVo> tagVoList) {
        return tagVoList.stream().map(TagVo::tagName).toList();
    }
}

package by.jacviah.winery.dao.util.mapper;

import by.jacviah.winery.dao.entity.BottleEntity;
import by.jacviah.winery.model.Bottle;
import by.jacviah.winery.model.Rate;

import java.time.Year;

public class BottleMapper {

    public static BottleEntity toEntity(Bottle dto) {
        return BottleEntity.BottleEntityBuilder.aBottleEntity()
                .withId(dto.getId())
                .withWine(WineMapper.toEntity(dto.getWine()))
                .withUser(UserMapper.toEntity(dto.getUser()))
                .withIsDrunk(dto.isDrunk())
                .withRate(dto.getRate().getValue())
                .withDate(dto.getDate())
                .withYear(dto.getYear().toString())
                .build();
    }

    public static Bottle toDTO(BottleEntity entity) {
        return Bottle.BottleBuilder.aBottle()
                .withId(entity.getId())
                .withWine(WineMapper.toDTO(entity.getWine()))
                .withUser(UserMapper.toDTO(entity.getUser()))
                .withIsDrunk(entity.isDrunk())
                .withRate(Rate.asRate(entity.getRate()))
                .withDate(entity.getDate())
                .withYear(Year.parse(entity.getYear()))
                .build();
    }
}

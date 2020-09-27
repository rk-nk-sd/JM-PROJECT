package jm.stockx.api.dao;

import jm.stockx.dto.ItemTopInfoDto;
import jm.stockx.dto.SellerTopInfoDto;
import jm.stockx.dto.SellingInfoDto;
import jm.stockx.entity.SellingInfo;

import java.time.LocalDateTime;
import java.util.List;

public interface SellingInfoDAO extends GenericDao<SellingInfo, Long> {
    Double getAverageSalesValue();

    SellingInfoDto getSellingInfoDtoById(Long id);

    List<SellerTopInfoDto> getTopSellingUsers();

    int getNumberSalesForSpecifiedPeriod(LocalDateTime beginningPeriod, LocalDateTime endPeriod);

    List<ItemTopInfoDto> getItemTopInfoDto(int maxResult);
}

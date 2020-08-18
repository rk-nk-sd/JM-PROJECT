package jm.stockx.dto;

import jm.stockx.entity.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemPostDto {

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private Double price;

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private Double lowestAsk;

    @Positive(message = "Ставка должна быть положительной")
    @NotNull
    private Double highestBid;

    @NotNull
    private LocalDate dateRelease;

    @NotBlank
    private String condition;

    public ItemPostDto(Item item) {
        this.price = item.getPrice();
        this.lowestAsk = item.getLowestAsk();
        this.highestBid = item.getHighestBid();
        this.dateRelease = item.getReleaseDate();
        this.condition = item.getCondition();
    }
}

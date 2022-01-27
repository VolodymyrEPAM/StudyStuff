package converter;

import java.math.BigDecimal;

public class Calvin implements Converter {
    @Override
    public BigDecimal convert(double farengeits) {
        BigDecimal calvin = new BigDecimal((farengeits - 32) * 5 / 9 + 273.15);
        calvin = calvin.setScale(3, BigDecimal.ROUND_CEILING);
        return calvin;
    }
}  

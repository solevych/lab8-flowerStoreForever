package labflowercontinue.flowers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/flowers/")
public class FlowerController {
    private static final double EXAMPLE_LENGTH = 12.5;
    private static final double EXAMPLE_PRICE = 5.0;

    @GetMapping("/list")
    public List<Flower> flowers() {
        return List.of(
                new Flower(
                        EXAMPLE_LENGTH,
                        FlowerColor.RED,
                        EXAMPLE_PRICE,
                        FlowerType.Rose
                )
        );
    }
}


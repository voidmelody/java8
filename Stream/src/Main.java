import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("아메리카노", 3000, true));
        coffees.add(new Coffee("라떼", 5000, false));
        coffees.add(new Coffee("마끼야또", 4500, false));
        coffees.add(new Coffee("더치커피", 4000, true));
        coffees.add(new Coffee("프라푸치노", 5500, false));

        List<Coffee> nonCoffees = new ArrayList<>();
        nonCoffees.add(new Coffee("망고주스", 3000, true));
        nonCoffees.add(new Coffee("딸바쥬스", 5000, true));
        nonCoffees.add(new Coffee("딸기에이드", 4500, true));

        List<List<Coffee>> drinks = new ArrayList<>();
        drinks.add(coffees);
        drinks.add(nonCoffees);

        // filter // 가격이 5000원보다 싼 애들만 가져와보자!
        System.out.println("가격이 5000원보다 싼 애들만 가져와보자!!");
        coffees.stream().filter(c -> c.getPrice() < 5000)
                .forEach(c->{
                    System.out.println(c.getName());
                });

        System.out.println("----------------------");

        // map // 커피들의 이름을 가져와 보자
        System.out.println("커피들의 이름을 가져와 보자!!");
        coffees.stream().map(Coffee::getName)
                .forEach(System.out::println);
        System.out.println("----------------------");

        // flatMap // 이중 리스트를 분해해보자!
        System.out.println("이중 리스트를 분해해보자!!");
        drinks.stream().flatMap(Collection::stream)
                .forEach(d-> System.out.println(d.getName()));
        System.out.println("----------------------");

        // iterate , limit, skip
        System.out.println("스트림을 반복해보자!!");
        Stream.iterate(10, c -> c += 2)
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("----------------------");

        // anyMatch
        System.out.println("4000원인 커피가 있나요?");
        boolean is4000 = coffees.stream().anyMatch(c -> c.getPrice() == 4000);
        System.out.println(is4000);
        System.out.println("----------------------");

        // allMatch
        System.out.println("nonCoffee는 다 판매 중인가요?");
        boolean isAllSail = nonCoffees.stream().allMatch(Coffee::isSail);
        System.out.println(isAllSail);
        System.out.println("----------------------");

        // noneMatch
        System.out.println("커피 중에 1000원짜리는 없죠?");
        boolean b = coffees.stream().noneMatch(c -> c.getPrice() == 1000);
        System.out.println("----------------------");

        // count
        System.out.println("드링크의 갯수는 어떻게 되나요?");
        long drinkCount = drinks.stream().count();
        System.out.println(drinkCount);
        System.out.println("----------------------");

        // reduce
        // 첫 번째 요소와 두 번째 요소를 가지고 연산을 수행한 뒤, 그 결과와 세 번째 요소를 가지고 또 다른 연산 수행
        Optional<Integer> sum = coffees.stream().map(Coffee::getPrice)
                .reduce(Integer::sum);
        sum.ifPresent(System.out::println);
        System.out.println("----------------------");

        // collect
        System.out.println("가격을 출력해보자");
        List<Integer> prices = coffees.stream().map(Coffee::getPrice)
                .collect(Collectors.toList());
        prices.forEach(System.out::println);
        System.out.println("----------------------");

        // sum
        System.out.println("마시는 것들의 모든 가격 총합을 구해볼까?");
        int sumDrink = drinks.stream().flatMap(Collection::stream)
                .mapToInt(Coffee::getPrice)
                .sum();
        System.out.println(sumDrink);
        System.out.println("----------------------");

        // max
        System.out.println("마시는 것들 중 가장 비싼 걸 구해보자.");
        OptionalInt max = drinks.stream().flatMap(Collection::stream)
                .mapToInt(Coffee::getPrice)
                .max();
        if(max.isPresent()){
            System.out.println(max.getAsInt());
        }
    }
}
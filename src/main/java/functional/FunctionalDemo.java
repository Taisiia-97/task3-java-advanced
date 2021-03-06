package functional;

import java.util.ArrayList;
import java.util.List;
//dodajemy adnotacje, ze to jest interface funkcyjny
@FunctionalInterface
interface FunctionWithTwoOperands {
    double operator(double a, double b);
}

class Addition implements FunctionWithTwoOperands {

    @Override
    public double operator(double a, double b) {
        return a + b;
    }
}

public class FunctionalDemo {
    public static void main(String[] args) {
        FunctionWithTwoOperands add = new Addition();
        FunctionWithTwoOperands diff = new FunctionWithTwoOperands() {
            @Override
            public double operator(double a, double b) {
                return a - b;
            }
        };
        List<FunctionWithTwoOperands> commands = new ArrayList<>();
        commands.add(add);
        commands.add(diff);
        //wyrazenia lambda
        commands.add((a, b) -> a * b);
        //rownoważnik lambdy
        commands.add(new FunctionWithTwoOperands() {
            @Override
            public double operator(double a, double b) {
                return a * b;
            }
        });
        //rozbudowana lambda
        commands.add((a,b)->{
            double result = Math.pow(a,b);
            return result;

        });
    }
}

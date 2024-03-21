import java.util.Scanner;

public class ResolucaoDeTodosOsEcercicios{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Média entre três números inteiros");
        System.out.println("2. Verificar se dois números são positivos");
        System.out.println("3. Determinar o maior de dois números");
        System.out.println("4. Classificar um número como positivo, negativo ou zero");
        System.out.println("5. Imprimir o nome do dia da semana");
        System.out.println("6. Imprimir os primeiros 10 números da sequência de Fibonacci");
        System.out.println("7. Imprimir a tabuada de um número");
        System.out.println("8. Ler números do usuário e imprimir a soma");
        System.out.println("9. Imprimir uma matriz de multiplicação de 5x5");
        System.out.println("10. Desenhar um triângulo de asteriscos");
        System.out.println("11. Fibonacci com condições especiais");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                Media();
                break;
            case 2:
                classNumero();
                break;
            case 3:
                determinarMaior();
                break;
            case 4:
                Positividade();
                break;
            case 5:
                DiaDaSemana();
                break;
            case 6:
                serieFibonacci();
                break;
            case 7:
                Tabuada();
                break;
            case 8:
                lerESomar();
                break;
            case 9:
                MatrizMultiplicacao();
                break;
            case 10:
                TrianguloAsteristico();
                break;
            case 11:
                seriefibonacci2();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void Media() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escreva o primeiro numero  : ");
        int numUM = scanner.nextInt();11


        System.out.print("Escreva o segundo numero: ");
        int numDois = scanner.nextInt();

        System.out.print("Escreva o terceiro numero: ");
        int numtres = scanner.nextInt();

        int media = (numUM + numDois+ numtres) / 3;
        System.out.println("A média é: " + media);
    }

    public static void Positividade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escreva um numero: ");
        int numUM = scanner.nextInt();

        System.out.print("Escreva um outro: ");
        int numDois = scanner.nextInt();

        if(numUM > 0 & numDois > 0 ){
            System.out.print("Os numeros "+numUM+" e "+numDois+"  Sao positivos!");
        } else if(numUM < 0 & numDois > 0  ){
            System.out.print("O numero "+numUM+" e negativo  e o numero "+numDois+"  e positivo!");
        } else if(numUM > 0 & numDois < 0 ){
            System.out.print("O numero "+numUM+" e positivo  e o numero "+numDois+"  e Negativo!");
        } else {
            System.out.print("Os numeros "+numUM+" e "+numDois+" sao Negativos!");
        }
        scanner.close();
    }

    public static void determinarMaior() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escreva um numero: ");
        int numUM = scanner.nextInt();

        System.out.print("Escreva um outro: ");
        int numDois = scanner.nextInt();
        int maior = numUM > numDois ? numUM : numDois;
        System.out.println("O maior número é: " + maior);
    }

    public static void classNumero() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Escreva um numero: ");
        int numUM = scanner.nextInt();

        System.out.print("Escreva um outro: ");
        int numDois = scanner.nextInt();

        if(numUM > 0 & numDois > 0 ){
            System.out.print(true);
        } else {
            System.out.print(false);
        }
        scanner.close();
    }

    public static void DiaDaSemana() {
        int dia = 1;
        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Dia inválido");
        }
    }

    public static void serieFibonacci() {
        int n1 = 0, n2 = 1;
        System.out.print(n1 + " " + n2);
        for (int i = 2; i < 10; i++) {
            int n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }

    public static void Tabuada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int num = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void lerESomar() {
        Scanner scanner = new Scanner(System.in);
        int num;
        int soma = 0;
        do {
            System.out.print("Digite um número (0 para sair): ");
            num = scanner.nextInt();
            soma += num;
        } while (num != 0);
        System.out.println("Soma: " + soma);
    }

    public static void MatrizMultiplicacao() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void TrianguloAsteristico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a altura do triângulo: ");
        int altura = scanner.nextInt();
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void  seriefibonacci2() {
        int n1 = 0, n2 = 1;
        System.out.print(n1 + " ");
        while (true) {
            int n3 = n1 + n2;
            if (n3 > 100) break;
            if (n3 % 4 != 0) System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
    }
}

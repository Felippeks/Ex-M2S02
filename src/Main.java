import entidades.Paciente;
import repositorio.RepositorioPaciente;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - Cadastrar um novo paciente");
            System.out.println("2 - Listar todos os pacientes");
            System.out.println("3 - Alterar informações do paciente");
            System.out.println("4 - Mostrar informações de um paciente");
            System.out.println("5 - Registrar atividade física para um paciente");
            System.out.println("6 - Remover paciente");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção:");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    alterarPaciente();
                    break;
                case 4:
                    mostrarPaciente();
                    break;
                case 5:
                    registrarAtividadeFisica();
                    break;
                case 6:
                    removerPaciente();
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            if (opcao == 7) {
                break;
            }
        }
    }

    private static void cadastrarPaciente() {
        Paciente paciente = new Paciente();
        System.out.println("Digite o nome do paciente:");
        paciente.setNome(scanner.nextLine());
        System.out.println("Digite a idade do paciente:");
        paciente.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.println("Digite o peso do paciente:");
        paciente.setPeso(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a altura do paciente:");
        paciente.setAltura(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a pressão arterial do paciente:");
        paciente.setPressaoArterial(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a frequência cardíaca do paciente:");
        paciente.setFrequenciaCardiaca(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a dieta alimentar do paciente:");
        paciente.setDietaAlimentar(scanner.nextLine());
        RepositorioPaciente.adicionar(paciente);
    }

    private static void listarPacientes() {
        List<Paciente> pacientes = RepositorioPaciente.listar();
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            System.out.println("ID: " + i + ", Nome: " + p.getNome());
        }
    }

    private static void alterarPaciente() {
        System.out.println("Digite o id do paciente que deseja alterar:");
        int idAlterar = Integer.parseInt(scanner.nextLine());
        Paciente pacienteAlterar = RepositorioPaciente.buscarPorId(idAlterar);
        System.out.println("Digite o novo peso do paciente:");
        pacienteAlterar.setPeso(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a nova altura do paciente:");
        pacienteAlterar.setAltura(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a nova pressão arterial do paciente:");
        pacienteAlterar.setPressaoArterial(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a nova frequência cardíaca do paciente:");
        pacienteAlterar.setFrequenciaCardiaca(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a nova dieta alimentar do paciente:");
        pacienteAlterar.setDietaAlimentar(scanner.nextLine());
        RepositorioPaciente.alterar(idAlterar, pacienteAlterar);
    }

    private static void mostrarPaciente() {
        System.out.println("Digite o id do paciente que deseja visualizar:");
        int idVisualizar = Integer.parseInt(scanner.nextLine());
        Paciente pacienteVisualizar = RepositorioPaciente.buscarPorId(idVisualizar);
        System.out.println(pacienteVisualizar.monitoramentoPaciente());
    }

    private static void registrarAtividadeFisica() {
        System.out.println("Digite o id do paciente que deseja registrar uma atividade física:");
        int idAtividade = Integer.parseInt(scanner.nextLine());
        Paciente pacienteAtividade = RepositorioPaciente.buscarPorId(idAtividade);
        System.out.println("Digite a atividade física:");
        String atividade = scanner.nextLine();
        pacienteAtividade.registrarAtividadeFisica(atividade);
    }

    private static void removerPaciente() {
        System.out.println("Digite o id do paciente que deseja remover:");
        int idRemover = Integer.parseInt(scanner.nextLine());
        RepositorioPaciente.remover(idRemover);
    }
}
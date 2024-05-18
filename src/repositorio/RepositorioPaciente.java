package repositorio;

import entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPaciente {
    private static List<Paciente> pacientes = new ArrayList<>();

    public static void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static void remover(int id) {
        pacientes.remove(id);
    }

    public static Paciente buscarPorId(int id) {
        return pacientes.get(id);
    }

    public static List<Paciente> listar() {
        return pacientes;
    }

    public static void alterar(int id, Paciente paciente) {
        pacientes.set(id, paciente);
    }
}
package pe.edu.upeu.calcfx.control;
import pe.edu.upeu.calcfx.servicio.Puntos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TictacControl {

    @FXML
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
    @FXML
    private TextField nombreJugador1, nombreJugador2;
    @FXML
    private Label turnoLabel;
    @FXML
    private TableView<Puntos> tablaPuntajes;

    @FXML
    private TableColumn<Puntos, Integer> NumeroPartido;
    @FXML
    private TableColumn<Puntos, String> Jugador1;
    @FXML
    private TableColumn<Puntos, String> Jugador2;
    @FXML
    private TableColumn<Puntos, String> Ganador;
    @FXML
    private TableColumn<Puntos, String> Puntuacion;
    @FXML
    private TableColumn<Puntos, String> Estado;

    private ArrayList<Puntos> partidas = new ArrayList<>();
    private Button[][] tablero;
    private boolean turno = true;
    private String jugador1, jugador2, jugadorActual;
    private int contadorPartidas = 1;

    @FXML
    public void initialize() {
        eldefecto();
        tablero = new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20, btn21, btn22}
        };

        // unir con la clase puntos
        NumeroPartido.setCellValueFactory(new PropertyValueFactory<>("numeroPartido"));
        Jugador1.setCellValueFactory(new PropertyValueFactory<>("jugador1"));
        Jugador2.setCellValueFactory(new PropertyValueFactory<>("jugador2"));
        Ganador.setCellValueFactory(new PropertyValueFactory<>("ganador"));
        Puntuacion.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));
        Estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    @FXML
    public void iniciar() {
        jugador1 = nombreJugador1.getText();
        jugador2 = nombreJugador2.getText();
        jugadorActual = jugador1;
        turno = true;
        limpiarTablero();
        activaDesacticaB(false);
        actualizarTurno();
    }

    @FXML
    public void anular() {
        alpreisonar();
        activaDesacticaB(true);
    }
    @FXML
    public void eldefecto(){
        activaDesacticaB(true);
    }

    @FXML
    void accionButon(ActionEvent e) {
        Button boton = (Button) e.getSource();
        if (boton.getText().isEmpty()) {
            boton.setText(turno ? "X" : "O");
            if (verificarGanador()) {
                String ganador = turno ? jugador1 : jugador2;
                registrarResultado(ganador, "Terminado", "1");
            } else if (esEmpate()) {
                registrarResultado("Empate", "Terminado", "0");
            } else if (esEmpate()) {
                registrarResultado("Empate", "Terminado", "0");
            }else {
                turno = !turno;
                jugadorActual = turno ? jugador1 : jugador2;
                actualizarTurno();
            }
        }
    }

    public boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            //es para comprobar si las filas columas y diagonles son iguale
            if (tablero[i][0].getText().equals(tablero[i][1].getText()) &&
                    tablero[i][0].getText().equals(tablero[i][2].getText()) && !tablero[i][0].getText().isEmpty()) {
                eldefecto();
                return true;

            }
            if (tablero[0][i].getText().equals(tablero[1][i].getText()) &&
                    tablero[0][i].getText().equals(tablero[2][i].getText()) && !tablero[0][i].getText().isEmpty()) {
                eldefecto();
                return true;
            }
        }
        if (tablero[0][0].getText().equals(tablero[1][1].getText()) &&
                tablero[0][0].getText().equals(tablero[2][2].getText()) && !tablero[0][0].getText().isEmpty()) {
            eldefecto();
            return true;
        }
        if (tablero[0][2].getText().equals(tablero[1][1].getText()) &&
                tablero[0][2].getText().equals(tablero[2][0].getText()) && !tablero[0][2].getText().isEmpty()) {
            eldefecto();
            return true;
        }
        return false;
    }

    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }


    public void registrarResultado(String ganador, String estado, String puntuacion) {
        Puntos nuevoPuntaje = new Puntos(contadorPartidas, jugador1, jugador2, ganador, estado, puntuacion);
        partidas.add(nuevoPuntaje);
        tablaPuntajes.getItems().add(nuevoPuntaje);
        contadorPartidas++;
    }

    public void actualizarTurno() {
        turnoLabel.setText("Turno: " + jugadorActual + " (" + (turno ? "X" : "O") + ")");
    }

    public void activaDesacticaB(boolean indi) {
        btn00.setDisable(indi);
        btn01.setDisable(indi);
        btn02.setDisable(indi);
        btn10.setDisable(indi);
        btn11.setDisable(indi);
        btn12.setDisable(indi);
        btn20.setDisable(indi);
        btn21.setDisable(indi);
        btn22.setDisable(indi);
    }

    public void limpiarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j].setText("");
            }
        }
    }
    @FXML
    void alpreisonar (){
        registrarResultado("Anulado", "Terminado", "0");
    }
}

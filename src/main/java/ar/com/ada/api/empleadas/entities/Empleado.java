package ar.com.ada.api.empleadas.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {
    
    public Empleado(){
    }

    public Empleado(String nombre, Integer edad, BigDecimal sueldo){
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.setEstado(EstadoEmpleadoEnum.ACTIVO);
        this.fechaAlta = new Date();
    }

    @Id
    @Column(name="empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empleadoId;

    private String nombre;

    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;

    private BigDecimal sueldo;

    @Column(name = "estado_id")
    private int estado;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_alta")
    private Date fechaAlta;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_baja")
    private Date fechaBaja;


    public enum EstadoEmpleadoEnum {
        ACTIVO(1), BAJA(2);

        private final int value;

        // NOTE: Enum constructor tiene que estar en privado
        private EstadoEmpleadoEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static EstadoEmpleadoEnum parse(int id) {
            EstadoEmpleadoEnum status = null; // Default
            for (EstadoEmpleadoEnum item : EstadoEmpleadoEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    public EstadoEmpleadoEnum getEstado() {
        return EstadoEmpleadoEnum.parse(this.estado);
    }

    public void setEstado(EstadoEmpleadoEnum estado) {
        this.estado = estado.getValue();
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }
    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        categoria.agregarEmpleado(this);
    }
    public BigDecimal getSueldo() {
        return sueldo;
    }
    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Date getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
}

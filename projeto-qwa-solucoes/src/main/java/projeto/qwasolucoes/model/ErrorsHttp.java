package projeto.qwasolucoes.model;

public class ErrorsHttp {

    private Integer httpStatus;

    private String descricaoErro;

    public ErrorsHttp(Integer httpStatus, String descricaoErro) {
        this.httpStatus = httpStatus;
        this.descricaoErro = descricaoErro;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDescricaoErro() {
        return descricaoErro;
    }

    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }
}

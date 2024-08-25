package com.nttdata.glue;

import com.nttdata.steps.PedidoStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PedidoStepDef {
    @Steps
    PedidoStep pedidoStep;
    @When("creo el pedido con id {string}, pedID {string}, quantity {string}, shipDate{string}, status {string}, complete, {string}")
    public void crearPedido(String id, String petId, String quantity, String shipDate, String status, String complete) {
        pedidoStep.crearPedido(id,petId,quantity,shipDate,status,complete);
    }

    @Then("el código de respuesta de pedido es {int}")
    public void elCódigoDeRespuestaDePedidoEs(int statusCode)
    { pedidoStep.validarCodigoRespuesta(statusCode);}

    @And("el campo status es {string}")
    public void elCampoStatusEs(String status)
    {pedidoStep.validarStatus(status);}

    @Given("consulto el pedido con ID {string}")
    public void consultoElPedidoConID(String id)
    {
        Assert.assertTrue("No existe pedido",pedidoStep.consultarPedido(id));
    }
}

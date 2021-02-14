package gas.station;

class GasStation {

    private int amountGallonsOfGas;
    private int amountGallonsOfGasNeeded;

    GasStation(int amountGallonsOfGas, int amountGallonsOfGasNeeded) {
        this.amountGallonsOfGas = amountGallonsOfGas;
        this.amountGallonsOfGasNeeded = amountGallonsOfGasNeeded;
    }

    int getAmountGallonsOfGas() {
        return amountGallonsOfGas;
    }

    int getAmountGallonsOfGasNeeded() {
        return amountGallonsOfGasNeeded;
    }
}

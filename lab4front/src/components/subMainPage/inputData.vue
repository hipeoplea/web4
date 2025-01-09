<template>
    <form class="main" @submit.prevent="handleClick">
      <h2>Введите данные</h2>
      <div class="form-group">
        <label for="x" class="label">X</label>
        <input
            id="x"
            type="text"
            class="textInput"
            v-model="x"
            placeholder="-5 ... 3"
            required
        />
      </div>

      <div class="form-group">
        <label for="y" class="label">Y</label>
        <input
            id="y"
            type="text"
            class="textInput"
            v-model="y"
            placeholder="-3 ... 3"
            required
        />
      </div>

      <div class="form-group">
        <label for="r" class="label">R</label>
        <input
            id="r"
            type="text"
            class="textInput"
            v-model="r"
            placeholder="0 ... 3"
            required
            @input="updateGraph"
        />
      </div>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <button type="submit" class="btn">Отправить</button>
    </form>
</template>

<script>
export default {
  name: 'FormComponent',
  data() {
    return {
      x: '',
      y: '',
      r: '',
      errorMessage: ''
    };
  },
  methods: {
    handleClick() {
      if (!this.validateFields()) return;

      this.$emit('submit-data', {
        x: this.x,
        y: this.y,
        r: this.r
      });

      this.x = '';
      this.y = '';
      this.r = '';
      this.errorMessage = '';
    },

    validateFields() {
      const xNum = parseFloat(this.x);
      const yNum = parseFloat(this.y);
      const rNum = parseFloat(this.r);
      console.log(xNum, yNum, rNum);
      if (isNaN(xNum) || xNum < -5 || xNum > 3) {
        this.errorMessage = 'X должен быть числом от -5 до 3.';
        return false;
      }

      if (isNaN(yNum) || yNum < -3 || yNum > 3) {
        this.errorMessage = 'Y должен быть числом от -3 до 3.';
        return false;
      }

      if (isNaN(rNum) || rNum < 0 || rNum > 3) {
        this.errorMessage = 'R должен быть числом от 0 до 3.';
        return false;
      }

      return true;
    },

    updateGraph() {
      if (!(this.r >= 0 && this.r <= 3)) {
        this.errorMessage = 'R должен быть числом от 0 до 3.'
        return;
      }
      this.errorMessage = '';
      this.$emit('update-graph', this.r);
    }
  }
};
</script>

<style scoped>

.main {
  display: inline-grid;
  padding: 10px 10px;
  border-radius: 16px;
  background: #ecf0f3;
  box-shadow: 4px 4px 4px 0 #d1d9e6 inset,
  -4px -4px 4px 0 #d1d9e6 inset;
  grid-area: main;
  font-style: oblique;
  place-items: center;
  margin: auto 50px;
  gap: 10px;
}

.form-group {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
  width: 100%;
}

.textInput {
  font-size: 16px;
  border-radius: 8px;
  line-height: 1.5;
  padding: 5px 10px;
  transition: box-shadow 100ms ease-in, border 100ms ease-in, background-color 100ms ease-in;
  border: 2px solid #dee1e2;
  color: rgb(53, 53, 87);
  background: #dee1e2;
  display: block;
  height: 36px;
  width: 100%;
  box-sizing: border-box;
  max-width: 80%;
}

.textInput:hover {
  border-color: #ccc;
}

.label {
  margin-right: 10px;
  font-size: 16px;
  color: #394a56;
}

.btn {
  display: block;
  margin: 20px auto;
  padding: 10px 20px;
  background: #e2e8ed;
  border: none;
  border-radius: 10px;
  box-shadow: 0 5px 0 #c6cfdd;
  font-size: 16px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.btn:hover {
  background: #bec5d3;
  box-shadow: none;
  position: relative;
  top: 5px;
}
.error {
  color: red;
  margin-top: 10px;
  font-size: 14px;
}
</style>

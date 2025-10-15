<template>
  <div class="dashboard">
    <h2>My Tickets</h2>
    <ul>
      <li v-for="ticket in tickets" :key="ticket.id">{{ ticket.title }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      tickets: [],
    };
  },
  created() {
    this.fetchTickets();
  },
  methods: {
    async fetchTickets() {
      try {
        const response = await axios.get('http://localhost:8080/tickets', {
          headers: { Authorization: `Bearer ${this.$store.state.token}` },
        });
        this.tickets = response.data;
      } catch (error) {
        console.error('Error fetching tickets:', error);
      }
    },
  },
};
</script>

<style scoped>
.dashboard {
  padding: 20px;
}
ul {
  list-style-type: none;
}
li {
  margin: 10px 0;
}
</style>

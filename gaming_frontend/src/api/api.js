import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080", // Spring Boot backend
});

// Example APIs
export const login = (credentials) => API.post("/auth", credentials);
export const searchMember = (phone) => API.post("/members/search", { phone });
export const playGame = (memberId, gameId) =>
  API.post("/members/play", { member_id: memberId, game_id: gameId });

export default API;

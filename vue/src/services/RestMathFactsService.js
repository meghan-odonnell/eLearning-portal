import axios from 'axios'

const API_URL = 'http://numbersapi.com/random/math'


export default {
  getMathFact() {
    // const url = API_URL
    return axios.get(API_URL)
  }
}
import env from './env'

const DEV_URL = 'http://localhost:8080'
const PRO_URL = 'http://10.20.133.87:80'

export default env === 'development' ? DEV_URL : PRO_URL

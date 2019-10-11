import api from '../src/config/api'
let cacheUserName = ''
const users = {
  admin: {
    roles: ['admin'],
    introduction: 'I am a super administrator',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Super Admin'
  },
  editor: {
    roles: ['editor'],
    introduction: 'I am an editor',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Normal Editor'
  }
}

export default [
  // user login
  {
    url: api.login[0],
    type: api.login[1],
    response: config => {
      const { username } = config.body
      const user = users[username]

      // mock error
      if (!user) {
        return {
          code: 5001,
          message: 'Account and password are incorrect.'
        }
      }
      cacheUserName = username

      return {
        code: 1000,
        data: user
      }
    }
  },

  // get user info
  {
    url: api.getInfo[0],
    type: api.getInfo[1],
    response: config => {
      return {
        code: 1000,
        data: users[cacheUserName]
      }
    }
  },

  // user logout
  {
    url: api.logout[0],
    type: api.logout[1],
    response: _ => {
      return {
        code: 1000,
        data: 'success'
      }
    }
  }
]
